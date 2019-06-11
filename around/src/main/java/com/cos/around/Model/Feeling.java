package com.cos.around.Model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Data;

	@Data
	@Entity
	@Table(
		uniqueConstraints={
			@UniqueConstraint(
				columnNames={"feelingName"}
			)
		}
	)
	
public class Feeling {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feelingNum;
	
	@Column(nullable = false, length = 60)
	private String feelingName;
	@Column(nullable = false)
	private String feelingEmoticon;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "feeling")
	private List<Board> board;

	@CreationTimestamp
	private LocalDate feelingCreateDate;
	@CreationTimestamp
	private LocalDate feelingUpdateDate;

}
