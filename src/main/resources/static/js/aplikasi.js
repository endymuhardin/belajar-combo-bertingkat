$(document).ready(function(){
    var urlProvinsi = "/api/provinsi";

    var templateUrlKabupaten = "/api/provinsi/{provinsi}/kabupaten";
    var templateUrlKecamatan = "/api/kota/{kabupatenkota}/kecamatan";
    var templateUrlKelurahan = "/api/kecamatan/{kecamatan}/kelurahan";

    var urlKabupaten = null;
    var urlKecamatan = null;
    var urlKelurahan = null;

    var provinsi = null;
    var kabupatenKota = null;
    var kecamatan = null;
    var kelurahan = null;

    var inputProvinsi = $("#provinsi");
    var inputKabupatenKota = $("#kabupatenKota");
    var inputKecamatan = $("#kecamatan");
    var inputKelurahan = $("#kelurahan");
    var inputKodepos = $("#kodepos");

    var resetInput = function(inputField){
        inputField.val('');
        inputField.prop('disabled', true);
    };

    resetInput(inputKabupatenKota);
    resetInput(inputKecamatan);
    resetInput(inputKelurahan);

    inputProvinsi.typeahead({
        displayText: function(item){ return item.nama;},
        source: _.debounce(function(cari, process){
            provinsi = null;
            resetInput(inputKabupatenKota);
            resetInput(inputKecamatan);
            resetInput(inputKelurahan);
            $.get(urlProvinsi, {nama: cari}, function(hasil){
                process(hasil);
            }, "json");
        }, 500),
        afterSelect: function(pilihan){
            provinsi = pilihan;
            inputKabupatenKota.prop('disabled', false);
            urlKabupaten = _.replace(templateUrlKabupaten, '{provinsi}', provinsi.id);
        }
    });

    inputKabupatenKota.typeahead({
        displayText: function(item){ return item.nama;},
        source: _.debounce(function(cari, process){
            kabupatenKota = null;
            resetInput(inputKecamatan);
            resetInput(inputKelurahan);
            $.get(urlKabupaten, {nama: cari}, function(hasil){
                process(hasil);
            }, "json");
        }, 500),
        afterSelect: function(pilihan){
            kabupatenKota = pilihan;
            inputKecamatan.prop('disabled', false);
            urlKecamatan = _.replace(templateUrlKecamatan, '{kabupatenkota}', kabupatenKota.id);
        }
    });

    inputKecamatan.typeahead({
        displayText: function(item){ return item.nama;},
        source: _.debounce(function(cari, process){
            kecamatan = null;
            resetInput(inputKelurahan);
            $.get(urlKecamatan, {nama: cari}, function(hasil){
                process(hasil);
            }, "json");
        }, 500),
        afterSelect: function(pilihan){
            kecamatan = pilihan;
            inputKelurahan.prop('disabled', false);
            urlKelurahan = _.replace(templateUrlKelurahan, '{kecamatan}', kecamatan.id);
        }
    });

    inputKelurahan.typeahead({
        displayText: function(item){ return item.nama;},
        source: _.debounce(function(cari, process){
            kecamatan = null;
            $.get(urlKelurahan, {nama: cari}, function(hasil){
                process(hasil);
            }, "json");
        }, 500),
        afterSelect: function(pilihan){
            kelurahan = pilihan;
            inputKodepos.val(kelurahan.kodepos);
        }
    });
});