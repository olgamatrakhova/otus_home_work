-- Table: my_schema.t_question

-- DROP TABLE IF EXISTS my_schema.t_question;

CREATE TABLE IF NOT EXISTS my_schema.t_question
(
    id_question integer NOT NULL,
    nm_question varchar(1000) NOT NULL,
    CONSTRAINT t_question_pkey PRIMARY KEY (id_question)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS my_schema.t_question
    OWNER to postgres;

COMMENT ON TABLE my_schema.t_question
    IS 'Таблица Вопросов';

COMMENT ON COLUMN my_schema.t_question.id_question
    IS 'Идентификатор вопроса';

COMMENT ON COLUMN my_schema.t_question.nm_question
    IS 'Текст вопроса';

INSERT INTO my_schema.t_question(
	id_question, nm_question)
	VALUES (1, 'Какое животное обитает только в Китае'),
	(2, 'Чем питаются колибри'),
	(3, 'Как называются молодые рога марала, изюбря и пятнистого оленя'),
	(4, 'Какая наука изучает ископаемых животных');	
	


-- Table: my_schema.t_answer

-- DROP TABLE IF EXISTS my_schema.t_answer;

CREATE TABLE IF NOT EXISTS my_schema.t_answer
(
    id_answer integer NOT NULL,
    nn_number integer NOT NULL,
    nm_answer character(1000) COLLATE pg_catalog."default" NOT NULL,
    id_question integer NOT NULL,
    pr_true integer NOT NULL DEFAULT 0,
    CONSTRAINT t_answer_pkey PRIMARY KEY (id_answer),
    CONSTRAINT t_answer_fkey FOREIGN KEY (id_question)
        REFERENCES my_schema.t_question (id_question) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS my_schema.t_answer
    OWNER to postgres;

COMMENT ON COLUMN my_schema.t_answer.id_answer
    IS 'Идентификатор ответа';

COMMENT ON COLUMN my_schema.t_answer.nn_number
    IS 'Номер ответа по порядку в вопросе';

COMMENT ON COLUMN my_schema.t_answer.nm_answer
    IS 'Текст ответа';

COMMENT ON COLUMN my_schema.t_answer.id_question
    IS 'Идентификатор вопроса, которому принаждедат вопросы';

COMMENT ON COLUMN my_schema.t_answer.pr_true
    IS 'Признак правильного ответа';
-- Index: fki_t_answer_fkey

-- DROP INDEX IF EXISTS my_schema.fki_t_answer_fkey;

CREATE INDEX IF NOT EXISTS fki_t_answer_fkey
    ON my_schema.t_answer USING btree
    (id_question ASC NULLS LAST)
    TABLESPACE pg_default;	
	
INSERT INTO my_schema.t_answer(
	id_answer, nn_number, nm_answer, id_question, pr_true)
	VALUES 
	 (1, 1, 'Коала', 1, 0),
	 (2, 2, 'Верблюд', 1, 0),
	 (3, 3, 'Панда', 1, 1),
	 (4, 4, 'Слон', 1, 0),
	 (5, 5, 'Носорог', 1, 0),
     (6, 1, 'Нектаром и мелкими насекомыми', 2, 1),
	 (7, 2, 'Мелкой рыбой', 2, 0),
	 (8, 3, 'Семенами трав', 2, 0),
	 (9, 4, 'Лягушками', 2, 0),
     (10, 1, 'Пуанты', 3, 0), 
	 (11, 2, 'Пенаты', 3, 0),
	 (12, 3, 'Панты', 3, 1),
     (13, 1, 'Сейсмология', 4, 0),
	 (14, 2, 'Орнитология', 4, 0), 
	 (15, 3, 'Психология', 4, 0),
	 (16, 4, 'Палеонтология', 4, 1),
	 (17, 5, 'Геология', 4, 0),
	 (18, 6, 'География', 4, 0);	
	 
SELECT tq.id_question, tq.nm_question, ta.id_answer, ta.nn_number, ta.nm_answer, ta.pr_true
  FROM my_schema.t_question tq
 join my_schema.t_answer ta
   on ta.id_question = tq.id_question
order by tq.id_question, ta.nn_number;	 
	