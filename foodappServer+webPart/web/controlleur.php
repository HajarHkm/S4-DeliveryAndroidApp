<?php
require'modele.php';
require'v_all.php';
require 'v_insert.php';
require 'v_update.php';
require 'v_login.php';

class controlleur {
	private $action;
	private $modele;
	private $vue;

	public function __construct()
	{
		$this->modele=new modele ();
		$this->action="login";
	}

	public function allAction()
	{
		$plats=
			$this->modele->select_plats();
			$this->vue=new v_all("all");
			$this->vue->all($plats);
			$this->vue->afficher();
	}

	public function newAction()
	{
		$this->vue=new v_insert("neww");
		$this->vue->neww();
		$this->vue->afficher();
	}

	public function addAction()
	{
		
		$plat=$_POST;

		$this->modele->add_plat(array($plat['nomplat'],$plat['prixplat'],$plat['categorieplat'],$plat['description']));
		//echo($plat['nomplat'] ."nop". $plat['prixplat'] ."nop".$plat['categoryplat']);
		header('location:controlleur.php?action=all');

	}

	public function delAction()
	{
		$idplat=$_GET['idplat'];
		$this->modele->delete_plat($idplat);
		header('location:controlleur.php?action=all');
	}

	public function updateAction()
	{
		$idplat=$_GET['idplat'];
		$plat=$this->modele->select_plat(array($idplat));
		$this->vue=new v_update("update");
		$this->vue->add($plat);
		//$this->vue->one($client);
		$this->vue->afficher();
	}
	public function valupdateAction()
	{
		$plat=$_POST;
		$this->modele->update_plat(array($plat['nomplat'],$plat['prixplat'],$plat['categorieplat'],$plat['description'], $plat['idplat']));

		
		header('location:controlleur.php?action=all');
	}

		public function loginAction()
	{
		

		$this->vue=new v_login("login");
		$this->vue->login();
		$this->vue->afficher();

	}

	public function log()
	{
		
		$login=$_POST;
		$gerant=null;
		$gerant=
			$this->modele->login_gerant(array($login['login'],$login['mdp']));
		
		if($gerant != null)
		{
			header('location:controlleur.php?action=all');
		} else echo("failed");

	
	}

	public function disconnect()
	{
		header('location:controlleur.php?action=login');
	}


	public function action()
	{
		$action="login";
		if(isset($_GET['action']))
		$action=$_GET['action'];
		if(isset($_POST['action']))
		$action=$_POST['action'];

		switch($action)
		{
			case 'all' :
			$this->allAction();
			break;
			case 'new' :
			$this->newAction();
			break;
			case 'add' :
			$this->addAction();
			break;	
			case 'del' :
			$this->delAction();
			break;		
			case 'update' :
			$this->updateAction();
			break;
			case 'valupdate' :
			$this->valupdateAction();
			break;
			case 'login':
			$this->loginAction();
			break;
			case 'log':
			$this->log();
			break;
			case 'disconnect':
			$this->disconnect();
			break;
		
		}
	}


}

$c=new controlleur();
$c->action();

?>