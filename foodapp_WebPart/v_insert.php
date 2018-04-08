<?php
require_once 'vue.php';
class v_insert extends vue{



	public function neww()
	{
			$this->content.="<center></br><a href='controlleur.php?action=disconnect'><img src='disconnect.png'></a></center>
				<center><h1>Ajouter un Plat</h1></br><form action='controlleur.php?action=add' method='POST'>";
			$this->content.="<table border=1 align=center>";

			$this->content.="<tr><td>Nom Plat</td><td><input type='text' name='nomplat'></td></tr>";
			$this->content.="<tr><td>Prix Plat</td><td><input type='text' name='prixplat' ></td></tr>";
			$this->content.="<tr><td>Categorie Plat</td><td><input type='text' name='categorieplat' ></td></tr>";
			$this->content.="<tr><td>Description</td><td><input type='text' name='description' ></td></tr>";
			$this->content.="</table>";
			$this->content.="</br><button type='submit'>Ajouter</button><a href=controlleur.php><button>Retourner</button></a>";
			$this->content.="</form></center>";

		
	} 
}

?>