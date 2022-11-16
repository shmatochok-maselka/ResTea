import {flavour, type, origin, property} from "./categories";

export interface Product {
  id: number;
  name: string;
  description: string;
  price: number;
  image: string;
  type: type;
  origin: origin;
  flavors: Array<flavour>;
  properties: Array<property>;
}
