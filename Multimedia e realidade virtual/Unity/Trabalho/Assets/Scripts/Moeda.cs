using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Moeda : MonoBehaviour
{

    // Start is called before the first frame update
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {

    }

    void OnCollisionEnter(Collision collision)
    {
        if (collision.gameObject.name == "Terreno")
        {
            if (gameObject != null)
            {
                if(gameObject.tag == "Moeda")
                {
                    Chest.pontos -= 1;
                }
                Destroy(gameObject);
            }
        }
        

    }
}
