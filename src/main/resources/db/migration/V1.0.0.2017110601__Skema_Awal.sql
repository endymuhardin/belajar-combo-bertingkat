CREATE TABLE provinsi (
  id   VARCHAR(36),
  nama VARCHAR(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (nama)
);

CREATE TABLE kabupaten_kota (
  id          VARCHAR(36),
  id_provinsi VARCHAR(36) NOT NULL,
  nama VARCHAR (255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (nama),
  FOREIGN KEY (id_provinsi) REFERENCES provinsi (id)
);

CREATE TABLE kecamatan (
  id                VARCHAR(36),
  id_kabupaten_kota VARCHAR(36)  NOT NULL,
  nama              VARCHAR(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (nama),
  FOREIGN KEY (id_kabupaten_kota) REFERENCES kabupaten_kota (id)
);

CREATE TABLE kelurahan (
  id           VARCHAR(36),
  id_kecamatan VARCHAR(36)  NOT NULL,
  nama         VARCHAR(255) NOT NULL,
  kodepos      VARCHAR(10)  NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (nama),
  FOREIGN KEY (id_kecamatan) REFERENCES kecamatan (id)
);

CREATE TABLE registrasi (
  id        VARCHAR(36),
  email     VARCHAR(255) NOT NULL,
  password  VARCHAR(255) NOT NULL,
  nama      VARCHAR(255) NOT NULL,
  alamat    VARCHAR(255) NOT NULL,
  id_kelurahan VARCHAR(36) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_kelurahan) REFERENCES kelurahan(id)
);
