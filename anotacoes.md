Utilizei o https://start.spring.io/

para teste: http://localhost:8080/recipes/search?ingredients=chicken

```
{
    "id": "52940",
    "name": "Brown Stew Chicken",
    "category": "Unknown",
    "area": null,
    "instructions": "Clique para ver detalhes",
    "image": "https://www.themealdb.com/images/media/meals/sypxpx1515365095.jpg"
  },
 ```

para teste utilizando o id: http://localhost:8080/recipes/details?id=52940

```
{
  "id": "52940",
  "name": "Brown Stew Chicken",
  "category": "Chicken",
  "area": "Jamaican",
  "instructions": "Squeeze lime over chicken and rub well. Drain off excess lime juice.\r\nCombine tomato, scallion, onion, garlic, pepper, thyme, pimento and soy sauce in a large bowl with the chicken pieces. Cover and marinate at least one hour.\r\nHeat oil in a dutch pot or large saucepan. Shake off the seasonings as you remove each piece of chicken from the marinade. Reserve the marinade for sauce.\r\nLightly brown the chicken a few pieces at a time in very hot oil. Place browned chicken pieces on a plate to rest while you brown the remaining pieces.\r\nDrain off excess oil and return the chicken to the pan. Pour the marinade over the chicken and add the carrots. Stir and cook over medium heat for 10 minutes.\r\nMix flour and coconut milk and add to stew, stirring constantly. Turn heat down to minimum and cook another 20 minutes or until tender.",
  "image": "https://www.themealdb.com/images/media/meals/sypxpx1515365095.jpg"
}
```

criar o recipe em model sem lombok por questao de bugs

endpoints
```
GET /recipes/search?ingredients=chicken,tomato
```
```
GET /recipes/details?id=52795
```