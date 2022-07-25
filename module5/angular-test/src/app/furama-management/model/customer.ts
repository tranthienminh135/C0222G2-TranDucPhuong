export class Customer {
  private _id?: number;
  private _name?: string;
  private _age?: number;

  constructor(id: number, name: string, age: number) {
    this._id = id;
    this._name = name;
    this._age = age;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get age(): number {
    return this._age;
  }

  set age(value: number) {
    this._age = value;
  }
}
