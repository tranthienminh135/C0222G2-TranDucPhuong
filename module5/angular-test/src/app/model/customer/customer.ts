import {CustomerType} from './customerType';

export class Customer {
  private _id?: number;
  private _address?: string;
  private _birthday?: string;
  private _email?: string;
  private _gender?: number;
  private _idCard?: string;
  private _name?: string;
  private _phoneNumber?: string;
  private _customerType?: CustomerType;

  constructor(id: number, address: string, birthday: string, email: string,
              gender: number, idCard: string, name: string, phoneNumber: string, customerType: CustomerType) {
    this._id = id;
    this._address = address;
    this._birthday = birthday;
    this._email = email;
    this._gender = gender;
    this._idCard = idCard;
    this._name = name;
    this._phoneNumber = phoneNumber;
    this._customerType = customerType;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get address(): string {
    return this._address;
  }

  set address(value: string) {
    this._address = value;
  }

  get birthday(): string {
    return this._birthday;
  }

  set birthday(value: string) {
    this._birthday = value;
  }

  get email(): string {
    return this._email;
  }

  set email(value: string) {
    this._email = value;
  }

  get gender(): number {
    return this._gender;
  }

  set gender(value: number) {
    this._gender = value;
  }

  get idCard(): string {
    return this._idCard;
  }

  set idCard(value: string) {
    this._idCard = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get phoneNumber(): string {
    return this._phoneNumber;
  }

  set phoneNumber(value: string) {
    this._phoneNumber = value;
  }

  get customerType(): CustomerType {
    return this._customerType;
  }

  set customerType(value: CustomerType) {
    this._customerType = value;
  }
}
