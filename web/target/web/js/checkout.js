var accessToken;

function login() {
    const email = 'thphung2@gmail.com';
    const password = '123456';

    $.ajax({
        url: "http://140.238.54.136/api/auth/login",
        type: "post",
        data: {
            email: email,
            password: password
        },
        success: function (response) {
            accessToken = response.access_token;
            console.log(accessToken);
        },
        error: function (xhr) {

        }
    });
}



function getProvince() {
    //Lấy danh sách các tỉnh
    $.ajax({
        url: "http://140.238.54.136/api/province",
        type: "get",
        data: {},
        beforeSend: function (xhr) {
            xhr.setRequestHeader('Authorization', 'Bearer ' + accessToken);
        },
        success: function (response) {
            const res = JSON.parse(response);
            let data = res.original.data;
            console.log(data);
            for (let i = 0; i < data.length; i++) {
                let item = '<option  class="option-select-province" value="' + data[i].ProvinceID + '">' + data[i].ProvinceName + '</option>';
                $('#select-province').append(item);
            }
        },
        error: function (xhr) {
        }
    });
}

function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

$(document).ready(async function () {
    let to_district_id;
    let to_ward_id;
    login();
    await sleep(3000);
    getProvince();
    $(document).on('change', '#select-province', function () {
        $('#select-district').children('.option-select-district').not('.default').remove();
        $('#select-ward').children('.option-select-ward').not('.default').remove();

        //Lấy danh sách các huyện của tỉnh
        const seProvince = $('#select-province');
        const provinceID =seProvince.val();

        if (provinceID == -1) return;
        $.ajax({
            url: "http://140.238.54.136/api/district",
            type: "get",
            data: {
                provinceID: provinceID
            },
            beforeSend: function (xhr) {
                xhr.setRequestHeader('Authorization', 'Bearer ' + accessToken);
            },
            success: function (response) {
                const res = JSON.parse(response);
                let data = res.original.data;
                for (let i = 0; i < data.length; i++) {
                    let item = '<option  class="option-select-district" value="' + data[i].DistrictID + '">' + data[i].DistrictName + '</option>';
                    $('#select-district').append(item);
                }
            },
            error: function (xhr) {
            }
        });
    })
    $(document).on('change', '#select-district', function () {
        $('#select-ward').children('.option-select-ward').not('.default').remove();

        //Lấy danh sách các xã của huyện
        const seDistrict = $('#select-district');
        const districtID = seDistrict.val();

        if (districtID == -1) return;
        to_district_id = districtID;
        $.ajax({
            url: "http://140.238.54.136/api/ward",
            type: "get",
            data: {
                districtID: districtID
            },
            beforeSend: function (xhr) {
                xhr.setRequestHeader('Authorization', 'Bearer ' + accessToken);
            },
            success: function (response) {
                const res = JSON.parse(response);
                let data = res.original.data;
                for (let i = 0; i < data.length; i++) {
                    let item = '<option  class="option-select-ward" value="' + data[i].WardCode + '">' + data[i].WardName + '</option>';
                    $('#select-ward').append(item);
                }
            },
            error: function (xhr) {
            }
        });
    })
    $(document).on('click', '.label-information', function () {
        getLeadTime(this);
    })

    $(document).on('change', '#select-ward', function () {
        const seWard = $('#select-ward');
        const wardID = seWard.val();
        if (wardID == -1) return;
        to_ward_id = wardID;
        getLeadTime();
    })

    function getLeadTime(label) {
        //API ước lượng thời gian vận chuyển từ xã, huyện này đến một xã, huyện khác
        $.ajax({
            url: "http://140.238.54.136/api/leadTime",
            type: "post",
            data: {
                from_district_id: 1451,
                from_ward_id: 20911,
                to_district_id: to_district_id,
                to_ward_id: to_ward_id,
                height: 10,
                length: 10,
                width: 10,
                weight: 10
            },
            beforeSend: function (xhr) {
                xhr.setRequestHeader('Authorization', 'Bearer ' + accessToken);
            },
            headers: {
                "X-Requested-With": "XMLHttpRequest"
            },
            success: function (response) {
                let data = response.data;
                shipDate = data[0].formattedDate;
                const date = new Date(shipDate);


                $('#lead-time').text(date.getDate() + '/' + (date.getMonth() + 1) + '/' + date.getFullYear());
            },
            error: function (xhr) {
            }
        });

        //API ước lượng chi phí khi vận chuyển từ xã, huyện, tỉnh này đến một xã, huyện, tỉnh khác
        $.ajax({
            url: "http://140.238.54.136/api/calculateFee ",
            type: "post",
            data: {
                from_district_id: 1451,
                from_ward_id: 20911,
                to_district_id: to_district_id,
                to_ward_id: to_ward_id,
                height: 10,
                length: 10,
                width: 10,
                weight: 10
            },
            beforeSend: function (xhr) {
                xhr.setRequestHeader('Authorization', 'Bearer ' + accessToken);
            },
            headers: {
                "X-Requested-With": "XMLHttpRequest"
            },
            success: function (response) {
                let data = response.data[0];
                shipFee = data.service_fee;
                $('.fee').text(shipFee.toLocaleString('vi-VN'));
                $('.total-price').text((total + shipFee).toLocaleString('vi-VN'));
            },
            error: function (xhr) {
            }
        })

    }
})

