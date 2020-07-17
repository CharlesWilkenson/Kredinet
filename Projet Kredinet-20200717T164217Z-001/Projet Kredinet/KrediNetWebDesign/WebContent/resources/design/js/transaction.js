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
    var champ_montant = document.getElementById('montant_depot');
    
    while (champ_montant.value.match(/[^0-9]/))
    {
        champ_montant.value = champ_montant.value.replace(/[^0-9]/,'');
    }
}
function onlyNumberNumeroCompte()
{
    var champ_numero_compte = document.getElementById('numero_compte');
    
    while (champ_numero_compte.value.match(/[^0-9]/))
    {
        champ_numero_compte.value = champ_numero_compte.value.replace(/[^0-9]/,'');
    }
}
function verif()
  { 
  if (document.layers)
    {
    formulaire = document.forms.monFormulaire;
    }
  else
    {
    formulaire = document.monFormulaire;
    }
  }

function verifChoixPays()
  {
  verif();
  if (formulaire.choixPays.value == "0")
    {
    alert('Vous devez tout d\'abord choisir un pays!');
    formulaire.choixPays.focus();
    }
  }

var villes = new Array();
villes[0] = new Array();
villes[1] = new Array("2", "3", "4","5")
villes[2] = new Array("2", "3", "4","5")
villes[3] = new Array("3", "4", "5","6")

function remplirVilles(code)
  {
  verif();
  var lesVilles = villes[code];

  if (code>0)
    {
    formulaire.choixVille.options.length = lesVilles.length;
    for (i=0; i<lesVilles.length; i++)
      {
      formulaire.choixVille.options[i].value = lesVilles[i];
      formulaire.choixVille.options[i].text = lesVilles[i];
      }
	  if(formulaire.choixPays.value == "1"){
		var input = document.getElementById("myInput");
		input.setAttribute("max",25000);
		input.setAttribute("min",5000);
		}else{
			var input = document.getElementById("myInput");
			input.setAttribute("max",50000);
			input.setAttribute("min",30000);
			input.setAttribute("step",5000);
		}
    document.monFormulaire.choixVille.options.selectedIndex = 0;
    }
  else
    {
	
    formulaire.choixVille.options.length = 1;
    formulaire.choixVille.options[0].value = 0;
    formulaire.choixVille.options[0].text = "-- choisissez une ville";
    }
  }
	