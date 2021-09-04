import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { InfoComponent } from './info/info.component';
import { Router } from '@angular/router';

@Component({
  selector: 'layout',
  templateUrl: './layout.component.html',
  styleUrls: [ './layout.component.scss' ],
})
export class LayoutComponent implements OnInit {

  constructor(public dialog: MatDialog,
    public route: Router) { }

  public ngOnInit(): void {
  }

  public openDialogInfo(): void {
    const dialogRef = this.dialog.open(InfoComponent, { width: '250px' });
  }

  public redirectToDoOrder(): void {
    this.route.navigate([this.route.url + '/create-order']);
  }
}
