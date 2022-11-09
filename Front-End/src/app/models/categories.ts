export interface Type{
  id: number;
  name: string;
}
export interface Origin{
  id: number;
  name: string;
}

export interface Flavor {
  id: number;
  name: string;
}

export interface Property{
  id: number;
  name: string;
}

export interface EntityFilterModel<T>{
  value:T;
  checked:boolean;
}

export interface FilterParamsModel{
  type:number[];
  origin:number[];
  flavor:number[];
  property:number[];
  name:string;
}
