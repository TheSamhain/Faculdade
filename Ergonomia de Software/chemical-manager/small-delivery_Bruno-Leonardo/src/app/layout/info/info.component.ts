import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  templateUrl: './info.component.html',
})

export class InfoComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<InfoComponent>) { }

  ngOnInit(): void {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

}
