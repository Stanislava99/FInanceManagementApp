package com.example.pfm.Repos;

import com.example.pfm.Models.MccCodesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MccCodesRepository extends JpaRepository <MccCodesEntity, Long> {
}
