
<?php
class modele {
	private $db;

	public function __construct()
	{
		define('user',"root");
		define('pass',"");
		$this->db = new PDO('mysql:host=localhost;dbname=foodapp',user,pass);
	}
	public function select_plats()
	{
		$query=$this->db->prepare('SELECT * from plat');
		$query->execute();
		return $query->fetchAll();
	}

	public function select_plat($idplat)
	{
		$query=$this->db->prepare('SELECT * FROM plat where idplat= ? ');
		$query->execute($idplat);
		return $query->fetch();
	}

	public function add_plat($plat)
	{
		$query=$this->db->prepare("INSERT INTO plat (idrestau,nomplat,prixplat,categorieplat,description) VALUES (1,?,?,?,?)");
		$query->execute($plat);
		//echo ("INSERT INTO employes (adresse,email,mdp,nom,prenom,sexe,dateNaissance,numServ) VALUES ('".$adresse."','".$email."','".$mdp."','".$nom."','".$prenom."','".$sexe."','".$dateNaissance."','".$numServ."') ");

	}

	public function delete_plat($idplat)
	{
		$query=$this->db->prepare('DELETE FROM plat  where idplat= ?');
		$query->execute(array($idplat));
	}


	public function update_plat($plat)
	{
		$query=$this->db->prepare('UPDATE plat set nomplat = ?, prixplat = ?, categorieplat = ? , description = ? WHERE idplat = ?');
		

		$query->execute($plat);
	}


	public function login_gerant($login)
	{
		$query=$this->db->prepare('SELECT * FROM gerant where loginrestau= ? and mdprestau= ?');
		$query->execute($login);
		return $query->fetch();

	}



}



?>