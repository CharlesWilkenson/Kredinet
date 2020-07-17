/**
 * 
 */
function onlyNumberTransaction()
{
    var champ = document.getElementById('id_transaction');
    while (champ.value.match(/[^0-9]/))
    {
        champ.value = champ.value.replace(/[^0-9]/,'');
    }
}
function onlyNumberMontant()
{
    var champ = document.getElementById('montant_depot');
    while (champ.value.match(/[^0-9]/))
    {
        champ.value = champ.value.replace(/[^0-9]/,'');
    }
}