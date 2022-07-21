import { Component, OnInit } from '@angular/core';
import {Facility} from '../../model/facility/facility';

@Component({
  selector: 'app-list',
  templateUrl: './list-facility.component.html',
  styleUrls: ['./list-facility.component.css']
})
export class ListFacilityComponent implements OnInit {
  facility: Facility[] = [];

  constructor() {
    this.facility.push(
      {id: 0, name: 'PHÒNG SUIT HƯỚNG BIỂN', area: 100, cost: 100000, maxPeople: 5, rentType: {id: 0, name: "year"}, standardRoom: "pro",
        descriptionOtherConvenience: "Phòng quyến rũ này nhìn ra khu vườn nhiệt đới xinh đẹp của chúng tôi và hồ bơi dạng đầm tạo cảnh. Vào ban đêm, hồ bơi và khu vườn được chiếu sáng lãng mạn.",
        numberOfFloors: 3, poolArea: 30,
        img: "https://furamavietnam.com/wp-content/uploads/2018/03/Vietnam_Danang_Furama_Ocean-Deluxe-double-bed-F-370x239.jpg"},
      {id: 1, name: 'PHÒNG SUIT HƯỚNG ĐỐI TƯỢNG', area: 100, cost: 100000, maxPeople: 5, rentType: {id: 0, name: "year"}, standardRoom: "pro",
        descriptionOtherConvenience: "Tôi nói thật với bạn phòng này như cái quần què đừng thuê bạn ạ! bạn cứ tin tôi, tôi còn đẻ ra được cái resort này có cái gì mà tôi không biết. bruhh... ",
        numberOfFloors: 3, poolArea: 30,
        img: "https://furamavietnam.com/wp-content/uploads/2018/03/Vietnam_Danang_Furama_Ocean-Studio-Suite-F-370x239.jpg"},
      {id: 2, name: 'PHÒNG SUIT HƯỚNG CẤU TRÚC', area: 100, cost: 100000, maxPeople: 5, rentType: {id: 0, name: "year"}, standardRoom: "pro",
        descriptionOtherConvenience: "Phòng quyến rũ này nhìn ra khu vườn nhiệt đới xinh đẹp của chúng tôi và hồ bơi dạng đầm tạo cảnh. Vào ban đêm, hồ bơi và khu vườn được chiếu sáng lãng mạn.",
        numberOfFloors: 3, poolArea: 30,
        img: "https://furamavietnam.com/wp-content/uploads/2018/03/Vietnam_Danang_Furama_Ocean-Deluxe-double-bed-F-370x239.jpg"},
      {id: 3, name: 'PHÒNG SUIT HƯỚNG SỰ KIỆN', area: 100, cost: 100000, maxPeople: 5, rentType: {id: 0, name: "year"}, standardRoom: "pro",
        descriptionOtherConvenience: "Phòng quyến rũ này nhìn ra khu vườn nhiệt đới xinh đẹp của chúng tôi và hồ bơi dạng đầm tạo cảnh. Vào ban đêm, hồ bơi và khu vườn được chiếu sáng lãng mạn.",
        numberOfFloors: 3, poolArea: 30,
        img: "https://furamavietnam.com/wp-content/uploads/2018/03/Vietnam_Danang_Furama_Lagoon-Superior-twin-bed-F-370x239.jpg"},
      {id: 4, name: 'PHÒNG SUIT HƯỚNG HÀM', area: 100, cost: 100000, maxPeople: 5, rentType: {id: 0, name: "year"}, standardRoom: "pro",
        descriptionOtherConvenience: "Phòng quyến rũ này nhìn ra khu vườn nhiệt đới xinh đẹp của chúng tôi và hồ bơi dạng đầm tạo cảnh. Vào ban đêm, hồ bơi và khu vườn được chiếu sáng lãng mạn.",
        numberOfFloors: 3, poolArea: 30,
        img: "https://furamavietnam.com/wp-content/uploads/2018/03/Vietnam_Danang_Furama_Garden-Superior-TwinBed-1-F-370x239.jpg"},
      {id: 5, name: 'PHÒNG SUIT HƯỚNG HÀM', area: 100, cost: 100000, maxPeople: 5, rentType: {id: 0, name: "year"}, standardRoom: "pro",
        descriptionOtherConvenience: "Phòng quyến rũ này nhìn ra khu vườn nhiệt đới xinh đẹp của chúng tôi và hồ bơi dạng đầm tạo cảnh. Vào ban đêm, hồ bơi và khu vườn được chiếu sáng lãng mạn.",
        numberOfFloors: 3, poolArea: 30,
        img: "https://furamavietnam.com/wp-content/uploads/2018/03/Vietnam_Danang_Furama_Garden-Superior-TwinBed-1-F-370x239.jpg"}
    )
  }

  ngOnInit(): void {
  }

}
