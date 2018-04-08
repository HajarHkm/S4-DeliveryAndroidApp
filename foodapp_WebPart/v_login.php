<?php
require_once 'vue.php';
class v_login extends vue{



	public function login()
	{
		$this->content.="<center><h2>Connectez-vous</h2>
						<form action='controlleur.php?action=log' method='POST'>
                        <table><tr><td>Login: </td><td><input type='text' name='login'></td></tr>";
        $this->content.="<tr><td>mdp: </td><td><input type='password' name='mdp' ></td></tr> </table>";
        
        $this->content.="</br><input type='submit' value='Connexion'>
        				<a href='controlleur.php?action=new'><button>Inscription</button></a></form></center>";              
                    
	} 
}

?>