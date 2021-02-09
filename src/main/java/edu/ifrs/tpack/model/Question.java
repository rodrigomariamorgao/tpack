package edu.ifrs.tpack.model;

import java.util.List;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
/**
* 
*
* @author Rodrigo Maria Morgão
*/
public class Question {

    @Id
    @GeneratedValue
    /**
    * 
    *
    * @author Rodrigo Maria Morgão
    */
    private long id;

    @Column(name = "TEXT", length = 1500)
    /**
    * 
    *
    * @author Rodrigo Maria Morgão
    */
    private String text;

    /* one explanation about the question */
    /**
    * 
    *
    * @author Rodrigo Maria Morgão
    */
    private String note;

    /* identify the type of the question */
    /**
    * 
    *
    * @author Rodrigo Maria Morgão
    */
    private QuestionType type;

    /* indicates the number os levels in multilevel questions */
    @Transient
    /**
    * 
    *
    * @author Rodrigo Maria Morgão
    */
    private byte levels;

    @ManyToOne
    @JoinColumn(name = "SESSION_ID", nullable = false)
    /**
    * 
    *
    * @author Rodrigo Maria Morgão
    */
    private Session session;

    @OneToMany(mappedBy = "question", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    /**
    * 
    *
    * @author Rodrigo Maria Morgão
    */
    private List<Choice> choices;

    @OneToMany(mappedBy = "question", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JsonbTransient
    /**
    * 
    *
    * @author Rodrigo Maria Morgão
    */
    private List<Answer> answers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public byte getLevels() {
        return levels;
    }

    public void setLevels(byte levels) {
        this.levels = levels;
    }

    @JsonbTransient
    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }
}