package com.example.volleykullanimi

//<?php
//
//$response = array();
//
//    if (isset($_POST['kisi_id']) && isset($_POST['kisi_ad']) && isset($_POST['kisi_tel']) ) {
//        $kisi_id = $_POST['kisi_id'];
//        $kisi_ad = $_POST['kisi_ad'];
//        $kisi_tel = $_POST['kisi_tel'];
//
//        //DB_SERVER,DB_USER,DB_PASSWORD,DB_DATABASE değişkenleri alınır.
//        require_once __DIR__ . '/db_config.php';
//
//        // Bağlantı oluşturuluyor.
//        $baglanti = mysqli_connect(DB_SERVER, DB_USER, DB_PASSWORD, DB_DATABASE);
//
//        // Bağlanti kontrolü yapılır.
//        if (!$baglanti) {
//            die("Hatalı bağlantı : " . mysqli_connect_error());
//        }
//
//        $sqlsorgu = "UPDATE kisiler SET kisiler.kisi_ad = '$kisi_ad',kisiler.kisi_tel = '$kisi_tel' WHERE kisiler.kisi_id = $kisi_id  ";
//
//    if (mysqli_query($baglanti, $sqlsorgu)) {
//        $response["success"] = 1;
//        $response["message"] = "successfully ";
//        echo json_encode($response);
//    } else {
//        $response["success"] = 0;
//        $response["message"] = "No product found";
//        echo json_encode($response);
//    }
//        //bağlantı koparılır.
//        mysqli_close($baglanti);
//} else {
//    $response["success"] = 0;
//    $response["message"] = "Required field(s) is missing";
//    echo json_encode($response);
//}
//?>