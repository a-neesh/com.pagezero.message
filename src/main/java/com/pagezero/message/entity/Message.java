package com.pagezero.message.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "messages")
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
public class Message extends Auditable<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "message_generator")
	@SequenceGenerator(
			name = "message_generator",
			sequenceName = "message_sequence",
			initialValue = 1
		)
	@Column(name="message_id")
	@Getter
	private Long messageId;
	
	@NotBlank
	@Getter @Setter
	@Size(min = 3, max = 100)
	private String title;
	
	@NotBlank
	@Getter @Setter
	private String canvas;
	
	@NotBlank
	@Getter @Setter
	private String recipient;

	public Message() {
		super();
	}
	
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "question_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private Question question;
	
	
}
