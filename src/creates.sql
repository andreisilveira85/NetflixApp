CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    country VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE profiles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    is_kid BOOLEAN NOT NULL DEFAULT FALSE,
    user_id BIGINT NOT NULL,
    CONSTRAINT fk_user
        FOREIGN KEY(user_id)
        REFERENCES users(id)
);

CREATE TABLE media_items (
    id SERIAL PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    genre VARCHAR(100) NOT NULL, -- Categoria (ex: Ação, Comédia, etc.)
    age_rating INT NOT NULL, -- Classificação Etária (ex: 0, 10, 12, 16, 18)
    country VARCHAR(100) NOT NULL, -- País de origem (ex: Brasil, EUA)
    release_year INT NOT NULL, -- Ano de Lançamento
    media_type VARCHAR(50) NOT NULL, -- Tipo de Mídia (ex: Filme, Série)
    popularity DOUBLE PRECISION NOT NULL, -- Popularidade (ex: 7.5)
    format VARCHAR(50) NOT NULL, -- Formato de Exibição (ex: HD, 4K)
    duration INT NOT NULL, -- Duração em minutos
    is_exclusive BOOLEAN NOT NULL DEFAULT FALSE, -- Exclusividade
    languages TEXT[], -- Idiomas Disponíveis
    actors TEXT[], -- Atores Principais
    director VARCHAR(100), -- Diretor
    subtitles TEXT[], -- Idiomas das Legendas Disponíveis
    has_audio_description BOOLEAN NOT NULL DEFAULT FALSE -- Áudio Descritivo
);
