using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GerarMoedas : MonoBehaviour
{
    public GameObject prefab;
    public float spacing = 2f;
    public int rand;
    public float timer = 0;
    public float timerrand = 0;
    public float timerdeley = 0;
    public float velocidade = 3;
    public bool deley = false;
    public Vector3 pos = new Vector3(494, 15, 115);
    public Vector3 rot = new Vector3(0, 0, 0);

    // Start is called before the first frame update
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {
        if (deley == false)
        {
            timer += Time.deltaTime;
            timerrand += Time.deltaTime;
            if (timerrand > 2)
            {
                rand = Random.Range(1, 6);
                switch (rand)
                {
                    case (1): pos = new Vector3(494, 15, 115); break;
                    case (2): pos = new Vector3(497, 15, 115); break;
                    case (3): pos = new Vector3(500, 15, 115); break;
                    case (4): pos = new Vector3(503, 15, 115); break;
                    case (5): pos = new Vector3(506, 15, 115); break;
                }
                timerrand = 0;
                deley = true;
                return;
            }

            if (timer > 0.5)
            {
                Instantiate(prefab, pos, Quaternion.Euler(rot));
                timer = 0;
            }
        }
        else
        {
            timerdeley += Time.deltaTime;
            timer = 0;
            if(timerdeley > velocidade)
            {
                deley = false;
                timerdeley = 0;
                velocidade *= (float)0.9;
            }
        }
    }
}
