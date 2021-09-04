using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class Chest : MonoBehaviour
{
    private Vector3 speed;
    private int velo = 3;
    public static int pontos = 0;
    public Text texto;

    public void Start()
    {
        speed = new Vector3(0, 0, 0);
    }

    public void Update()
    {
        texto.text = "Pontos: " + pontos;
        if (Input.GetKey(KeyCode.A) && transform.position.x > 493)
        {
            Esquerda();
        }

        else if (Input.GetKey(KeyCode.D) && transform.position.x < 507)
        {
            Direita();
        }
    }

    private void OnTriggerEnter(Collider collision)
    {
        if (collision.gameObject.tag == "Moeda")
        {
            if (collision.gameObject.tag != "Pontuar")
            {
                pontos += 1;
                collision.gameObject.tag = "Pontuar";
            }

        }
    }

    public void Esquerda()
    {
            speed.Set(-velo, 0, 0);
            transform.Translate(speed * Time.deltaTime);
        
    }

    public void Direita()
    {
        speed.Set(velo, 0, 0);
        transform.Translate(speed * Time.deltaTime);
    }
}
