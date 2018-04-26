<<<<<<< HEAD
<?php
require_once 'vue.php';
class v_all extends vue{



	public function all($plats)
	{
		$this->content.="

				<center></br><a href='controlleur.php?action=disconnect'><img src='disconnect.png'></a></center>
					<center><h1> Votre MENU </h1><table border=1 align=center>
						<tr><th hidden=''>Id Plat</th><th>Nom</th><th>Prix</th> <th>Description</th> <th>Suppression</th><th>Modifier</th></tr>";
		foreach ($plats as $plat)
		{


			$this->content.="<tr><td hidden=''>$plat[0]</td><td>$plat[2]</td><td>$plat[3]</td><td>$plat[5]</td>";
			$this->content.="<td align=center><a href=controlleur.php?action=del&idplat=".$plat[0].">
			<img src='delete.png'></a></td>";
			$this->content.="<td align=center><a href=controlleur.php?action=update&idplat=".$plat[0]."><img src='modify.png'></a></td>";
			$this->content.="</tr>";
		}
			$this->content.="</table> <p>Nombre de plats : ".count($plats)."</p>";
			$this->content.="</br><a href='controlleur.php?action=new'><button>Ajouter un Plat</button></a></center>";
	} 
}

=======
<?php
require_once 'vue.php';
class v_all extends vue{



	public function all($plats)
	{
		$this->content.="

				<center></br><a href='controlleur.php?action=disconnect'><img src='disconnect.png'></a></center>
					<center><h1> Votre MENU </h1><table border=1 align=center>
						<tr><th hidden=''>Id Plat</th><th>Nom</th><th>Prix</th> <th>Description</th> <th>Suppression</th><th>Modifier</th></tr>";
		foreach ($plats as $plat)
		{


			$this->content.="<tr><td hidden=''>$plat[0]</td><td>$plat[2]</td><td>$plat[3]</td><td>$plat[5]</td>";
			$this->content.="<td align=center><a href=controlleur.php?action=del&idplat=".$plat[0].">
			<img src='delete.png'></a></td>";
			$this->content.="<td align=center><a href=controlleur.php?action=update&idplat=".$plat[0]."><img src='modify.png'></a></td>";
			$this->content.="</tr>";
		}
			$this->content.="</table> <p>Nombre de plats : ".count($plats)."</p>";
			$this->content.="</br><a href='controlleur.php?action=new'><button>Ajouter un Plat</button></a></center>";
	} 
}

>>>>>>> 50a8311d9f9c9d38e133c3665e983f9119ea66a1
?>