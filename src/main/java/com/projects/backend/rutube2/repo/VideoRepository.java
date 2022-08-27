package com.projects.backend.rutube2.repo;

import com.projects.backend.rutube2.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

    @Query("SELECT v FROM Video v WHERE " +
            "(:name is null or :name='' " +
            "or lower(v.name) like lower(concat('%', :name, '%'))) " +
            "and v.isPublic=true " +
            "order by v.createdDate desc ")
    List<Video> findPublicByName(@Param("name") String name);

    @Query("SELECT v " +
            "FROM Video v " +
            "WHERE v.views=(SELECT MAX(v.views) FROM v)")
    Video findMostPopular();

}
