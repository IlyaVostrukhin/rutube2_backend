package com.projects.backend.rutube2.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "video", schema = "rutube", catalog = "rutube")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Video extends BaseEntity {

    private String name;

    @Column(name = "is_public")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isPublic = false;

    private Integer views = 0;

    private Integer likes = 0;

    private String duration = "";

    private String description = "";

    @Column(name = "video_path")
    private String videoPath = "";

    @Column(name = "thumbnail_path")
    private String thumbnailPath = "";

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "video")
    @JsonManagedReference
    private List<Comment> comments = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Video video = (Video) o;
        return getId().equals(video.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), user.getId());
    }

}
