<?php

class vue {
	protected $content;
	protected $title;
	public function __construct($title)
	{
		$this->title=$title;
		$this->content="<html><head><title>$title</title>
		<style>
@-webkit-keyframes autofill {
    to {
        color: #666;
        background: transparent;
    }
}

input:-webkit-autofill {
    -webkit-animation-name: autofill;
    -webkit-animation-fill-mode: both;
}

.bg {
    /* The image used */
    background-image: url('table.png');

    /* Full height */
    height: 100%; 

    /* Center and scale the image nicely */
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
}

p {
    text-transform: capitalize;
    color: white;
    
}



input[type=text],input[type=password] {

    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: none;

    border-bottom: 2px solid #A52A2A;
}
table {
    font-family: 'Trebuchet MS', Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 40%;
}

 td, th {
    border: 1px solid #ddd;
    padding: 8px;
    background-color: white;
}

 tr:nth-child(even){background-color: #f2f2f2;}

 tr:hover {background-color: #ddd;}
 th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #A52A2A;
    color: white;
}
button, input[type=submit] {
    background-color: #A52A2A; 
    border: none;
    color: white;
    padding: 20px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
    border-radius: 8px;
}
</style></head><div class='bg'><body>";
	}
	public function getContent()
	{ return $this->content;}
	public function finirContent()
	{ $this->content.="</div></body></html>"; }
	
	public function afficher()
	{
		$this->finirContent();
		echo $this->getContent();
	}
}

?>