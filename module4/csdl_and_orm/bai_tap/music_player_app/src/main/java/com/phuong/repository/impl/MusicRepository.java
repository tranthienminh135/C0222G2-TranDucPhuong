package com.phuong.repository.impl;

import com.phuong.repository.BaseRepository;
import com.phuong.model.Music;
import com.phuong.repository.IMusicRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MusicRepository implements IMusicRepository {

    @Override
    public List<Music> getAllMusic() {
        TypedQuery<Music> typedQuery = BaseRepository.entityManager.createQuery("select m from Music m", Music.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        try {
            BaseRepository.entityManager.persist(music);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        }
    }

    @Override
    public void delete(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        try {
            BaseRepository.entityManager.remove(BaseRepository.entityManager.find(Music.class,id));
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        }
    }

    @Override
    public Music findById(int id) {
        return BaseRepository.entityManager.find(Music.class, id);
    }
    @Override
    public void update(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        try {
            BaseRepository.entityManager.merge(music);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        }
    }
}
