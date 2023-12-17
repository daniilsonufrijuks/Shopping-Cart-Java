[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/Hm1GQmHH)

Izveidot konsoles (CLI) programmu. Tehniskās prasības:

Programmai jālasa datus no csv faila, kurš satur datus par pieiejamiem produktiem. Produktu tabulas kolonnas: id, name, price(double type), category.
Jābūt komandai lai apskatīt pieiejamos produktus, kurus būs iespēja ielikt grozā.
Jābūt iespējai pievienot produktu grozam (shopping cart).
Jābūt apskatīt informāciju par groza statusu.
Jābūt iespējai izņemt preci no groza.
Example CLI Commands:

add {product name} {quantity}
remove {product name}
list products
show cart
Realizācija:

Piemērs ar iespējamu risinājumu:

Izvedo ShoppingCart un Product klases.
main metodē, izveido jaunu ShoppingCart objektu, lai izmantotu pieiejamas metodes.
Arī var noderēt klase kura sniedz mums sarakstu ar Product klasses objektiem no CSV faila.
Papildus iespējas:

Pievienot iespēju veikt pasūtījumu un saglabāt pasūtījuma rēķinu kā JSON failu konkrētā projekta mapē savā CLI iepirkumu groza programmā, varat veikt šīs darbības. Katram pasūtījumam būs savs JSON fails un visi faili atrodas projekta mapē invoices.

Pievienojiet jaunu komandu CLI called place order.
Kad lietotājs ievada komandu place order, programmai ir jāaicina lietotāju ievadīt piegādes adresi.
Piegādes cenas aprēķināšanu var veikt pēc vienkāršas formulas, piemēram (piegādes cena = 10% no kopējā pirkuma cenas). 
Progammai jāaicina apstiprināt pasūtījumu (Place order: y/n).
Ja lietotājs apstiprina pasūtījumu, programmai jāsaglabā pasūtījuma rēķins kā JSON fails norādītajā projekta mapē.
Pasūtījuma rēķina JSON failā ir jābūt šādai informācijai:

Klienta vārds un piegādes adrese.
Iepirkumu grozā esošās preces, tostarp preces nosaukums, daudzums un cena.
Piegādes izmaksas.
Pasūtījuma kopējās izmaksas.