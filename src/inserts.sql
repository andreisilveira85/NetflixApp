INSERT INTO media_items (title, genre, age_rating, country, release_year, media_type, popularity, format, duration, is_exclusive, languages, actors, director, subtitles, has_audio_description)
VALUES
('A Grande Aventura', 'Aventura', 10, 'EUA', 2021, 'Filme', 8.5, '4K', 120, FALSE, ARRAY['Inglês', 'Espanhol'], ARRAY['João Silva', 'Maria Souza'], 'Steven Spielberg', ARRAY['Português', 'Inglês'], TRUE),
('Jornada Espacial', 'Ficção Científica', 12, 'Reino Unido', 2022, 'Filme', 9.1, 'HD', 135, TRUE, ARRAY['Inglês'], ARRAY['Carlos Almeida', 'Ana Costa'], 'Christopher Nolan', ARRAY['Inglês'], FALSE),
('Rir é o Melhor Remédio', 'Comédia', 16, 'Canadá', 2020, 'Série', 7.4, 'Full HD', 30, FALSE, ARRAY['Inglês', 'Francês'], ARRAY['José Pereira', 'Marcos Lima'], 'Edgar Wright', ARRAY['Português'], FALSE),
('A Ilha Misteriosa', 'Suspense', 18, 'Austrália', 2019, 'Filme', 8.2, 'HD', 110, TRUE, ARRAY['Inglês', 'Alemão'], ARRAY['Nicole Costa', 'Hugo Barbosa'], 'Martin Scorsese', ARRAY['Português', 'Inglês'], TRUE),
('Amor em Paris', 'Romance', 12, 'França', 2022, 'Filme', 8.9, '4K', 125, FALSE, ARRAY['Francês', 'Português'], ARRAY['Camila Monteiro', 'Pedro Alves'], 'Jean-Luc Godard', ARRAY['Português'], TRUE),
('Corrida Contra o Tempo', 'Ação', 14, 'Brasil', 2020, 'Filme', 7.8, 'HD', 95, FALSE, ARRAY['Português'], ARRAY['Lucas Andrade', 'Fernanda Lima'], 'Fernando Meirelles', ARRAY['Inglês'], FALSE),
('O Último Samurai', 'Drama', 16, 'Japão', 2003, 'Filme', 8.7, 'Full HD', 154, TRUE, ARRAY['Japonês', 'Inglês'], ARRAY['Ken Watanabe', 'Takeshi Kitano'], 'Edward Zwick', ARRAY['Português'], TRUE),
('Guerra e Paz', 'Histórico', 12, 'Rússia', 2016, 'Série', 9.0, 'Full HD', 50, TRUE, ARRAY['Russo', 'Inglês'], ARRAY['Vladimir Ivanov', 'Irina Petrova'], 'Sergey Bondarchuk', ARRAY['Português', 'Russo'], FALSE),
('Mundos Paralelos', 'Fantasia', 10, 'EUA', 2021, 'Filme', 8.0, '4K', 130, FALSE, ARRAY['Inglês'], ARRAY['Emma Stone', 'Ryan Gosling'], 'Tim Burton', ARRAY['Português', 'Inglês'], TRUE),
('Detetive Sem Nome', 'Policial', 14, 'Brasil', 2018, 'Filme', 7.5, 'HD', 105, FALSE, ARRAY['Português'], ARRAY['Carlos Antunes', 'Mariana Braga'], 'José Padilha', ARRAY['Inglês'], FALSE);
('Desafiadora Exploração', 'Aventura', 10, 'Reino Unido', 2018, 'Filme', 7.6, '4K', 115, FALSE, ARRAY['Inglês', 'Português'], ARRAY['Lucas Andrade', 'Fernanda Lima'], 'Cecília Matos', ARRAY['Português'], TRUE);
('História Sombria', 'Suspense', 16, 'Canadá', 2020, 'Série', 8.4, 'HD', 45, TRUE, ARRAY['Inglês', 'Francês'], ARRAY['Carlos Antunes', 'Mariana Braga'], 'José Padilha', ARRAY['Português'], TRUE);
('Eterna Batalha', 'Drama', 18, 'Japão', 2015, 'Filme', 8.1, 'Full HD', 135, FALSE, ARRAY['Japonês'], ARRAY['Camila Monteiro', 'Pedro Alves'], 'Ana Pereira', ARRAY['Japonês', 'Português'], TRUE);
('Odisseia Perdida', 'Ficção Científica', 12, 'EUA', 2019, 'Filme', 8.7, '4K', 120, TRUE, ARRAY['Inglês'], ARRAY['João Silva', 'Maria Souza'], 'Roberto Santos', ARRAY['Inglês', 'Português'], FALSE);
('Impressionante Lenda', 'Fantasia', 10, 'Alemanha', 2021, 'Filme', 8.5, 'HD', 125, FALSE, ARRAY['Alemão', 'Inglês'], ARRAY['Mariana Braga', 'Carlos Antunes'], 'Fernando Meirelles', ARRAY['Alemão', 'Português'], TRUE);
('Exploração Fantástica', 'Aventura', 12, 'França', 2020, 'Série', 7.9, 'Full HD', 50, TRUE, ARRAY['Francês', 'Inglês'], ARRAY['Fernanda Lima', 'Lucas Andrade'], 'Carlos Silva', ARRAY['Francês', 'Inglês'], TRUE);
('Lenda Eterna', 'Histórico', 14, 'Itália', 2018, 'Filme', 8.2, '4K', 150, FALSE, ARRAY['Italiano', 'Português'], ARRAY['Pedro Alves', 'Camila Monteiro'], 'Eduardo Lima', ARRAY['Italiano', 'Português'], FALSE);
('Viagem Desafiadora', 'Fantasia', 12, 'Brasil', 2022, 'Filme', 8.0, 'HD', 120, FALSE, ARRAY['Português'], ARRAY['Lucas Andrade', 'Fernanda Lima'], 'José Padilha', ARRAY['Português'], TRUE);
('Aventura Impossível', 'Ação', 14, 'EUA', 2016, 'Filme', 8.3, 'Full HD', 130, TRUE, ARRAY['Inglês'], ARRAY['João Silva', 'Maria Souza'], 'Ana Pereira', ARRAY['Inglês'], TRUE);
('Guerra Histórica', 'Histórico', 16, 'Rússia', 2019, 'Série', 9.0, '4K', 60, FALSE, ARRAY['Russo'], ARRAY['Camila Monteiro', 'Pedro Alves'], 'Cecília Matos', ARRAY['Russo', 'Português'], TRUE);
('Cidade de Deus', 'Drama', 18, 'Brasil', 2002, 'Filme', 9.2, 'HD', 130, FALSE, ARRAY['Português'], ARRAY['Alexandre Rodrigues', 'Leandro Firmino'], 'Fernando Meirelles', ARRAY['Inglês'], TRUE);
('Tropa de Elite', 'Ação', 16, 'Brasil', 2007, 'Filme', 8.9, 'Full HD', 115, TRUE, ARRAY['Português'], ARRAY['Wagner Moura', 'André Ramiro'], 'José Padilha', ARRAY['Inglês'], TRUE);
('Central do Brasil', 'Drama', 12, 'Brasil', 1998, 'Filme', 8.5, 'HD', 113, FALSE, ARRAY['Português'], ARRAY['Fernanda Montenegro', 'Vinícius de Oliveira'], 'Walter Salles', ARRAY['Inglês'], TRUE);
('O Auto da Compadecida', 'Comédia', 10, 'Brasil', 2000, 'Filme', 8.7, 'HD', 104, TRUE, ARRAY['Português'], ARRAY['Matheus Nachtergaele', 'Selton Mello'], 'Guel Arraes', ARRAY['Inglês'], FALSE);
('Que Horas Ela Volta?', 'Drama', 12, 'Brasil', 2015, 'Filme', 8.1, 'Full HD', 112, FALSE, ARRAY['Português'], ARRAY['Regina Casé', 'Camila Márdila'], 'Anna Muylaert', ARRAY['Inglês'], TRUE);
('Bacurau', 'Suspense', 16, 'Brasil', 2019, 'Filme', 8.6, '4K', 132, TRUE, ARRAY['Português'], ARRAY['Sônia Braga', 'Udo Kier'], 'Kleber Mendonça Filho', ARRAY['Inglês'], TRUE);
('Carandiru', 'Drama', 16, 'Brasil', 2003, 'Filme', 8.0, 'HD', 145, FALSE, ARRAY['Português'], ARRAY['Luiz Carlos Vasconcelos', 'Milton Gonçalves'], 'Héctor Babenco', ARRAY['Inglês'], TRUE);
('Aquarius', 'Drama', 16, 'Brasil', 2016, 'Filme', 8.2, 'Full HD', 142, FALSE, ARRAY['Português'], ARRAY['Sônia Braga', 'Humberto Carrão'], 'Kleber Mendonça Filho', ARRAY['Inglês'], TRUE);
('O Pagador de Promessas', 'Drama', 12, 'Brasil', 1962, 'Filme', 8.4, 'HD', 98, TRUE, ARRAY['Português'], ARRAY['Leonardo Villar', 'Glória Menezes'], 'Anselmo Duarte', ARRAY['Inglês'], TRUE);
('Dona Flor e Seus Dois Maridos', 'Comédia', 16, 'Brasil', 1976, 'Filme', 8.0, 'HD', 115, FALSE, ARRAY['Português'], ARRAY['Sônia Braga', 'José Wilker'], 'Bruno Barreto', ARRAY['Inglês'], TRUE);
('Turma da Mônica - Laços', 'Animação', 0, 'Brasil', 2019, 'Filme', 8.1, 'Full HD', 96, FALSE, ARRAY['Português'], ARRAY['Giulia Benite', 'Kevin Vechiatto'], 'Daniel Rezende', ARRAY['Inglês'], TRUE);
('O Menino e o Mundo', 'Animação', 0, 'Brasil', 2013, 'Filme', 8.2, 'HD', 80, FALSE, ARRAY['Português'], ARRAY['Vinicius Garcia', 'Lu Horta'], 'Alê Abreu', ARRAY['Inglês'], TRUE);
('Peixonauta: Agente Secreto da O.S.T.R.A.', 'Animação', 0, 'Brasil', 2012, 'Filme', 7.5, 'HD', 78, TRUE, ARRAY['Português'], ARRAY['Fábio Lucindo', 'Fernanda Bullara'], 'Célia Catunda', ARRAY['Português'], TRUE);
('Meu Amigãozão: O Filme', 'Animação', 0, 'Brasil', 2021, 'Filme', 7.9, 'HD', 85, FALSE, ARRAY['Português'], ARRAY['João Victor Granja', 'Angélica Borges'], 'André Breitman', ARRAY['Português'], TRUE);
('Sítio do Picapau Amarelo', 'Aventura', 0, 'Brasil', 2001, 'Série', 8.5, 'HD', 45, TRUE, ARRAY['Português'], ARRAY['Isabelle Drummond', 'Cacá Carvalho'], 'Emília Silva', ARRAY['Inglês'], TRUE);
('Castelo Rá-Tim-Bum', 'Fantasia', 0, 'Brasil', 1994, 'Série', 9.1, 'HD', 30, FALSE, ARRAY['Português'], ARRAY['Cássio Scapin', 'Rosi Campos'], 'Cao Hamburger', ARRAY['Português'], TRUE);
('Cocoricó', 'Animação', 0, 'Brasil', 1996, 'Série', 8.8, 'HD', 25, FALSE, ARRAY['Português'], ARRAY['Alain Fresnot', 'Marcelo Tas'], 'Fernando Gomes', ARRAY['Português'], TRUE);
('D.P.A. - Detetives do Prédio Azul', 'Aventura', 10, 'Brasil', 2012, 'Série', 8.3, 'Full HD', 25, TRUE, ARRAY['Português'], ARRAY['Tamara Taxman', 'Cláudio Mendes'], 'André Pellenz', ARRAY['Português'], TRUE);
('Galinha Pintadinha', 'Musical', 0, 'Brasil', 2006, 'Série', 8.0, 'HD', 20, FALSE, ARRAY['Português'], ARRAY['Juliano Prado', 'Mariana Caltabiano'], 'Juliano Prado', ARRAY['Português'], TRUE);
('Os Under-Undergrounds', 'Animação', 10, 'Brasil', 2016, 'Série', 7.8, 'Full HD', 25, FALSE, ARRAY['Português'], ARRAY['Renato Cavalcanti', 'Gabriel Christo'], 'Ricardo Peres', ARRAY['Português'], TRUE);
('E o Vento Levou', 'Drama', 12, 'EUA', 1939, 'Filme', 9.0, 'HD', 238, FALSE, ARRAY['Inglês'], ARRAY['Clark Gable', 'Vivien Leigh'], 'Victor Fleming', ARRAY['Português'], TRUE),
('Casablanca', 'Romance', 12, 'EUA', 1942, 'Filme', 8.9, 'HD', 102, FALSE, ARRAY['Inglês'], ARRAY['Humphrey Bogart', 'Ingrid Bergman'], 'Michael Curtiz', ARRAY['Português'], TRUE),
('Cidadão Kane', 'Drama', 14, 'EUA', 1941, 'Filme', 9.2, 'HD', 119, FALSE, ARRAY['Inglês'], ARRAY['Orson Welles', 'Joseph Cotten'], 'Orson Welles', ARRAY['Português'], TRUE),
('A Doce Vida', 'Drama', 16, 'Itália', 1960, 'Filme', 8.5, 'HD', 174, FALSE, ARRAY['Italiano'], ARRAY['Marcello Mastroianni', 'Anita Ekberg'], 'Federico Fellini', ARRAY['Português'], TRUE),
('Psicose', 'Suspense', 14, 'EUA', 1960, 'Filme', 8.7, 'HD', 109, FALSE, ARRAY['Inglês'], ARRAY['Anthony Perkins', 'Janet Leigh'], 'Alfred Hitchcock', ARRAY['Português'], TRUE),
('O Poderoso Chefão', 'Drama', 16, 'EUA', 1972, 'Filme', 9.2, 'HD', 175, FALSE, ARRAY['Inglês'], ARRAY['Marlon Brando', 'Al Pacino'], 'Francis Ford Coppola', ARRAY['Português'], TRUE),
('Lawrence da Arábia', 'Aventura', 12, 'Reino Unido', 1962, 'Filme', 8.9, 'HD', 218, FALSE, ARRAY['Inglês'], ARRAY['Peter O\'Toole', 'Alec Guinness'], 'David Lean', ARRAY['Português'], TRUE),
('A Noviça Rebelde', 'Musical', 10, 'EUA', 1965, 'Filme', 8.0, 'HD', 174, FALSE, ARRAY['Inglês'], ARRAY['Julie Andrews', 'Christopher Plummer'], 'Robert Wise', ARRAY['Português'], TRUE),
('2001: Uma Odisseia no Espaço', 'Ficção Científica', 10, 'EUA', 1968, 'Filme', 8.6, 'HD', 149, FALSE, ARRAY['Inglês'], ARRAY['Keir Dullea', 'Gary Lockwood'], 'Stanley Kubrick', ARRAY['Português'], TRUE),
('Cantando na Chuva', 'Musical', 0, 'EUA', 1952, 'Filme', 8.3, 'HD', 103, FALSE, ARRAY['Inglês'], ARRAY['Gene Kelly', 'Debbie Reynolds'], 'Stanley Donen', ARRAY['Português'], TRUE);
