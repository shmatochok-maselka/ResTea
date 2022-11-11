import {Flavor, Type, Origin, Property} from "./categories";

export interface Product {
  id: number;
  name: string;
  description: string;
  price: number;
  image: string;
  type: Type;
  origin: Origin;
  flavors: Array<Flavor>;
  properties: Array<Property>;
}
