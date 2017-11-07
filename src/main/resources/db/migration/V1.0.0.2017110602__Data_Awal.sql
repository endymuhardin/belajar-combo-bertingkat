INSERT INTO provinsi (id, nama) VALUES ('dki', 'DKI Jakarta');
INSERT INTO provinsi (id, nama) VALUES ('jatim', 'Jawa Timur');
INSERT INTO provinsi (id, nama) VALUES ('jabar', 'Jawa Barat');

INSERT INTO kabupaten_kota (id, id_provinsi, nama) VALUES ('kabbogor', 'jabar', 'Kabupaten Bogor');
INSERT INTO kabupaten_kota (id, id_provinsi, nama) VALUES ('kotabogor', 'jabar', 'Kota Bogor');
INSERT INTO kabupaten_kota (id, id_provinsi, nama) VALUES ('surabaya', 'jatim', 'Surabaya');
INSERT INTO kabupaten_kota (id, id_provinsi, nama) VALUES ('mojokerto', 'jatim', 'Mojokerto');

INSERT INTO kecamatan (id, id_kabupaten_kota, nama) VALUES ('cibinong', 'kabbogor', 'Cibinong');
INSERT INTO kecamatan (id, id_kabupaten_kota, nama) VALUES ('gnputri', 'kabbogor', 'Gunung Putri');
INSERT INTO kecamatan (id, id_kabupaten_kota, nama) VALUES ('bootimur', 'kotabogor', 'Bogor Timur');
INSERT INTO kecamatan (id, id_kabupaten_kota, nama) VALUES ('boobarat', 'kotabogor', 'Bogor Barat');
INSERT INTO kecamatan (id, id_kabupaten_kota, nama) VALUES ('rungkut', 'surabaya', 'Rungkut');
INSERT INTO kecamatan (id, id_kabupaten_kota, nama) VALUES ('wonokromo', 'surabaya', 'Wonokromo');
INSERT INTO kecamatan (id, id_kabupaten_kota, nama) VALUES ('mojosari', 'mojokerto', 'Mojosari');
INSERT INTO kecamatan (id, id_kabupaten_kota, nama) VALUES ('trowulan', 'mojokerto', 'Trowulan');

INSERT INTO kelurahan (id, id_kecamatan, nama, kodepos) VALUES ('tengah', 'cibinong', 'Tengah', '16914');
INSERT INTO kelurahan (id, id_kecamatan, nama, kodepos) VALUES ('pakansari', 'cibinong', 'Pakansari', '16915');
INSERT INTO kelurahan (id, id_kecamatan, nama, kodepos) VALUES ('ciangsana', 'gnputri', 'Ciangsana', '16968');
INSERT INTO kelurahan (id, id_kecamatan, nama, kodepos) VALUES ('cikeas', 'gnputri', 'Cikeas', '16966');
