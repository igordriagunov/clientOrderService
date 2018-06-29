package ru.itpark.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itpark.domain.Client;

import java.io.Serializable;
import java.util.List;

public interface ClientRepoJPAImpl extends JpaRepository <Client, Integer>{

}
