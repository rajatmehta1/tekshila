package com.tekshila.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.tekshila.domain.Course;
import com.tekshila.domain.EnrolledCourse;

import java.util.List;

@Repository
public interface EnrolCourseRepository extends MongoRepository<EnrolledCourse,String> {
    public List<EnrolledCourse> findEnrolledCourseByUserIdentity(String userIdentity);
    public List<EnrolledCourse> findEnrolledCourseByUserIdentityAndCourseId(String userIdentity, String courseId);
}
