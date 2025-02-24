package edu.icet.service.impl;

import edu.icet.dto.Teacher;
import edu.icet.entity.TeacherEntity;
import edu.icet.repository.TeacherDao;
import edu.icet.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private  final TeacherDao teacherDao;
    private final ModelMapper mapper;

    @Override
    public void addTeacher(Teacher teacher) {
        teacherDao.save(mapper.map(teacher, TeacherEntity.class));
    }

    @Override
    public List<Teacher> getAll() {
        List<TeacherEntity> teacherEntities = teacherDao.findAll();
        List<Teacher> teachers = new ArrayList<>();

        teacherEntities.forEach(teacher ->{
           teachers.add(mapper.map(teacher,Teacher.class));
        });
        return teachers;
    }

    @Override
    public void delete(Integer id) {
        teacherDao.deleteById(id);
    }

    @Override
    public void update(Teacher teacher) {
        teacherDao.save(mapper.map(teacher, TeacherEntity.class));
    }

    @Override
    public Teacher searchById(Integer id) {
        return mapper.map(teacherDao.findById(id),Teacher.class);
    }
}
