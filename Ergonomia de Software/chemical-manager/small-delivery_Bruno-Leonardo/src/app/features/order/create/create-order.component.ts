import { Component } from "@angular/core";
import { FormGroup, FormControlDirective, FormControl, FormArray, FormBuilder, AbstractControl } from '@angular/forms';

@Component({
    templateUrl: './create-order.component.html',
    styleUrls: [ './create-order.component.scss' ]
})

export class CreateOrderComponent {
    public products = [
        { name: 'Refrigerante' },
        { name: 'X Salada' },
        { name: 'X Bacon' },
        { name: 'Porção de Batata' },
        { name: 'Cachorro Quente' },
        { name: 'X Frango' },
        { name: 'Pizza' },
    ]

    public form: FormGroup; 

    constructor(private formBuilder: FormBuilder) {
        this.form = this.formBuilder.group({
            products: new FormArray([]),
            address: new FormControl(null)
        })
    }

    public submit(): void {

        alert(this.form.value.products);
        alert(this.form.controls.address.value);
    }
}

