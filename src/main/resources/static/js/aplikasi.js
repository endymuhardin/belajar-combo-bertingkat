window.addEventListener('load', function () {

    var urlProvinsi = "/api/provinsi";
    var aplikasi = new Vue({
        el: '#aplikasi-registrasi',
        components: {
            autocomplete: Vue2Autocomplete.default
        },
        data: {
            provinsi: null
        },
        methods: {
            selectProvinsi: function(prov){
                console.log(prov);
            }
        }
    });
});