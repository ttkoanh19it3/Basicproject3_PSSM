<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\ApiController as api;
/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/




Route::prefix('api')->group(function () {
    Route::get("csrfToken" , function(){ return csrf_token(); });
    Route::post('dangnhap', [api::class , "dangnhap"]);
    Route::get('lop2' , [api::class , 'lop2']);
    Route::get('lop3' , [api::class , 'lop3']);
    Route::get('monhoc' , [api::class , 'monhoc']);
    Route::get('lichhoc' , [api::class , 'lichhoc']);
    Route::get('ongvang', [api::class , 'getOngVang']);
    Route::get('xuatsac', [api::class , 'getXuatSac']);
    Route::get('gioi', [api::class , 'getGioi']);
    Route::get('getEmp1/{id}', [api::class , 'getEmp1']);
    Route::get('getEmp2/{id}', [api::class , 'getEmp2']);
    Route::post("addEmp1" , [api::class , 'addEmp1']);
    Route::post("addEmp2" , [api::class , 'addEmp2']);
    Route::post("editEmp1" , [api::class , 'editEmp1']);
    Route::post("editEmp2" , [api::class , 'editEmp2']);
    Route::get("xoalop1/{id_hs}" , [api::class , 'xoaLop1']);
    Route::get("xoalop2/{id_hs}" , [api::class , 'xoaLop2']);
    Route::post("doimatkhau" , [api::class , 'changePassword']);

});