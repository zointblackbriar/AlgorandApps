import {loadStdlib} from '@reach-sh/stdlib';
import * as backend from './build/index.main.mjs';

const stdlib = loadStdlib();

const accRole1 = await stdlib.newTestAccount(stdlib.parseCurrency(100)); 
const accRole2 = await stdlib.newTestAccount(stdlib.parseCurrency(100)); 

const ctcRole1 = accRole1.contract(backend); 
const ctcRole2 = accRole2.contract(backend, ctcRole1.getInfo());

await Promise.all([
    ctcRole1.participants.Role1({
        request: stdlib.parseCurrency(5),
        info: 'Verwendungszweck'
    }),
    ctcRole2.p.Role2({
        want: (amt) => console.log('Alice asked Bob for ${stdlib.formatCurrency(amt)}'),
        got: (secret) => console.log('Alices secret is: ${secret}')
    })
]);