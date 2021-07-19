INSERT INTO USUARIOS(nome, email, senha) VALUES('Aluno', 'aluno@email.com', '$2a$10$nn3k0y5kHyTHwdbCMKC9uu2sajSMoQxirOosN8.0tX3YTW3AVz5gC');
INSERT INTO USUARIOS(nome, email, senha) VALUES('Moderador', 'moderador@email.com', '$2a$10$nn3k0y5kHyTHwdbCMKC9uu2sajSMoQxirOosN8.0tX3YTW3AVz5gC');

INSERT INTO PERFIS(id, nome) VALUES(1, 'ROLE_ALUNO');
INSERT INTO PERFIS(id, nome) VALUES(2, 'ROLE_MODERADOR');

INSERT INTO USUARIOS_PERFIS(usuario_id, perfis_id) VALUES(1, 1);
INSERT INTO USUARIOS_PERFIS(usuario_id, perfis_id) VALUES(2, 2);

INSERT INTO CURSOS(nome, categoria) VALUES('Spring Boot', 'Programação');
INSERT INTO CURSOS(nome, categoria) VALUES('HTML 5', 'Front-end');

INSERT INTO TOPICOS(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida', 'Erro ao criar projeto', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICOS(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 2', 'Projeto não compila', '2019-05-05 19:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICOS(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 3', 'Tag HTML', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 1, 2);