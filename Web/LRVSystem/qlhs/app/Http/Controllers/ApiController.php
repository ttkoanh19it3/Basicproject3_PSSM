<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use DB;

class ApiController extends Controller
{
    public function dangnhap(Request $res){
        $user = DB::table('user')->where("user_name" , $res->user_name)->where("user_password" , $res->user_password)->first();
        if ($user == null) {
            echo "error";
        }
        else {
            echo $user->user_id;
        }    
    }

    public function lop2(){
        $lop2 = DB::table('lop11305')->get();
        echo json_encode($lop2, JSON_UNESCAPED_UNICODE);
    }

    public function lop3(){
        $lop3 = DB::table('khachhang')->get();
        echo json_encode($lop3, JSON_UNESCAPED_UNICODE);
    }

    public function monhoc(){
        $monhoc = DB::table('monhoc')->get();
        echo json_encode($monhoc, JSON_UNESCAPED_UNICODE);
    }

    public function lichhoc(){
        $lichhoc = DB::table('lichhoc')->get();
        echo json_encode($lichhoc , JSON_UNESCAPED_UNICODE);
    }

    public function getOngVang(){
        $ongvang = DB::table('khachhang')->where("DTB" , ">" , "9.8")->get();
        echo json_encode($ongvang , JSON_UNESCAPED_UNICODE);
    }

    public function getXuatSac(){
        $xuatsac = DB::table('khachhang')->where("DTB" , ">" , "9.5")->get();
        echo json_encode($xuatsac, JSON_UNESCAPED_UNICODE);
    }
    public function getGioi(){
        $gioi = DB::table('khachhang')->where("DTB" , ">" , "8")->get();
        echo json_encode($gioi , JSON_UNESCAPED_UNICODE);
    }

    public function getEmp2($id){
        $emp = DB::table('lop11305')->where("id" , $id)->first();
        echo json_encode($emp , JSON_UNESCAPED_UNICODE);
    }

    public function getEmp1($id){
        $emp = DB::table('khachhang')->where("id" , $id)->first();
        echo json_encode($emp , JSON_UNESCAPED_UNICODE);
    }

    public function addEmp1(Request $res) {
        $emp = DB::table('khachhang')->insert(["name" => $res->name , "masv" => $res->masv , "link" => $res->link , "DTB" => $res->DTB]);
    }

    public function addEmp2(Request $res) {
        $emp = DB::table('lop11305')->insert(["name" => $res->name , "masv" => $res->masv , "link" => $res->link , "DTB" => $res->DTB]);
    }

    public function editEmp1(Request $res){
        DB::table('khachhang')->where("id" , $res->id)->update(["name" => $res->name , "masv" => $res->masv , "link" => $res->link , "DTB" => $res->DTB]);
        echo $res->id;
    }

    public function editEmp2(Request $res){
        DB::table('lop11305')->where("id" , $res->id)->update(["name" => $res->name , "masv" => $res->masv , "link" => $res->link , "DTB" => $res->DTB]);
        echo $res->id;
    }


    public function xoaLop1($id){
        DB::table('khachhang')->where("id" , $id)->delete();
    }

    public function xoaLop2($id){
        DB::table('lop11305')->where("id" , $id)->delete();
    }

    public function changePassword(Request $res){
        $user = DB::table('user')->where("user_id" , $res->id)->first();
       
        if (strlen(trim($res->oldPassword)) <=0 || strlen(trim($res->newPassword)) <= 0) {
            echo "Bạn phải nhập đủ trường";
        }
        else {
           
            if ($res->oldPassword == $user->user_password){
                DB::table('user')->where("user_id" , $res->id)->update(['user_password' => $res->newPassword]);
                echo "Success";
     
            }
            else {
                echo "Mật khẩu cũ không đúng";
            }
        }

    }

}
