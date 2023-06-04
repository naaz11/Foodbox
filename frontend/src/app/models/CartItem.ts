import { Product } from "./Product";

export class CartItem{

  /* --------- Properties --------- */
  quantity:number = 1;
  price:number = this.product.productPrice;

  /* --------- Constructor --------- */
  //dependency injection on Product; this property is public so anyone can use it
  constructor(public product:Product){
  }

  /* --------- Methods --------- */

}
