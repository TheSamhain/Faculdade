import { Component, OnInit } from '@angular/core';

@Component({
  templateUrl: './order.component.html',
  styleUrls: [ './order.component.scss' ]
})

export class OrderComponent implements OnInit {

  public displayedColumns: string[] = ['product', 'date', 'status', 'value'];
  public dataSource: Order[]  = [
    { product: 'X Salada', date: '04/05/2020', status: 'Pendente', value: '20.00' },
    { product: 'Porção de Batata', date: '30/04/2020', status: 'Entregue', value: '15.00' },
    { product: 'Cachorro Quente', date: '01/05/2020', status: 'Entregue', value: '8.00' },
    { product: 'X Salada', date: '04/05/2020', status: 'Pendente', value: '15.00' },
    { product: 'Refrigerante', date: '04/05/2020', status: 'Pendente', value: '15.00' },
    { product: 'X Bacon', date: '04/05/2020', status: 'Em transporte', value: '18.00' },
    { product: 'X Egg', date: '04/05/2020', status: 'Em Transporte', value: '20.00' },
    { product: 'Porção de Batata', date: '30/04/2020', status: 'Entregue', value: '15.00' },
    { product: 'Cachorro Quente', date: '01/05/2020', status: 'Entregue', value: '8.00' },
    { product: 'X Salada', date: '04/05/2020', status: 'Pendente', value: '15.00' },
    { product: 'Refrigerante', date: '04/05/2020', status: 'Pendente', value: '15.00' },
    { product: 'X Bacon', date: '04/05/2020', status: 'Em transporte', value: '18.00' },
  ];

  constructor() { }

  ngOnInit(): void {
  }

}

export interface Order {
  product: string;
  date: string;
  status: string;
  value: string;
}
