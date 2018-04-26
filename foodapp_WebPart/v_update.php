<<<<<<< HEAD
<?php
require_once 'vue.php';
class v_update extends vue{



	public function add($plat)
	{
			$this->content.="
			<center></br><a href='controlleur.php?action=disconnect'><img src='disconnect.png'></a></center>
			<center><h1>Modifier le plat ".$plat['idplat']." </h1><form action='controlleur.php?action=valupdate' method='POST'>";
			$this->content.="<table border=1 align=center>";

			$this->content.="<tr hidden=''><td>idplat</td><td><input type='text' name='idplat' value='".$plat['idplat']."'></td></tr>";

			$this->content.="<tr><td>Nom Plat</td><td><input type='text' name='nomplat' value='".$plat['nomplat']."'></td></tr>";
			$this->content.="<tr><td>Prix Plat</td><td><input type='text' name='prixplat' value='".$plat['prixplat']."'></td></tr>";
			$this->content.="<tr><td>Categorie</td><td><input type='text' name='categorieplat' value='".$plat['categorieplat']."'></td></tr>";
			
			$this->content.="<tr><td>Description</td><td><input type='text' name='description' value='".$plat['description']."'></td></tr>";

			$this->content.="</table>";
			$this->content.="</br><button type='submit'>Modifier</button><a href=controlleur.php><button>Retourner</button></a>";
			$this->content.="</form></center>";

		
	} 
}

=======
<?php
require_once 'vue.php';
class v_update extends vue{



	public function add($plat)
	{
			$this->content.="
			<center></br><a href='controlleur.php?action=disconnect'><img src='disconnect.png'></a></center>
			<center><h1>Modifier le plat ".$plat['idplat']." </h1><form action='controlleur.php?action=valupdate' method='POST'>";
			$this->content.="<table border=1 align=center>";

			$this->content.="<tr hidden=''><td>idplat</td><td><input type='text' name='idplat' value='".$plat['idplat']."'></td></tr>";

			$this->content.="<tr><td>Nom Plat</td><td><input type='text' name='nomplat' value='".$plat['nomplat']."'></td></tr>";
			$this->content.="<tr><td>Prix Plat</td><td><input type='text' name='prixplat' value='".$plat['prixplat']."'></td></tr>";
			$this->content.="<tr><td>Categorie</td><td><input type='text' name='categorieplat' value='".$plat['categorieplat']."'></td></tr>";
			
			$this->content.="<tr><td>Description</td><td><input type='text' name='description' value='".$plat['description']."'></td></tr>";

			$this->content.="</table>";
			$this->content.="</br><button type='submit'>Modifier</button><a href=controlleur.php><button>Retourner</button></a>";
			$this->content.="</form></center>";

		
	} 
}

>>>>>>> 50a8311d9f9c9d38e133c3665e983f9119ea66a1
?>