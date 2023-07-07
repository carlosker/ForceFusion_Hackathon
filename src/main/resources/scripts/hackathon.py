# import urllib library
from urllib.request import urlopen

# import json
import json
import pprint

class User():
    username : str
    email : str
    shipping_details : str
    def __init__(self, input):
        self.username = input["username"]
        self.email = input["email"]
        self.shipping_details = input["shipping_details"]
    def __str__(self):
        return f"{self.username}, {self.email}\n{self.shipping_details}"
        
class Product():
    id : str
    name : str
    price : str
    def __init__(self, input):
        self.id = input["product_id"]
        self.name = input["product_name"]
        self.price = input["price_per_unit"]
    def __str__(self):
        return f"{self.id} - {self.name}\n{self.price}"


def retrieve_products():
    # store the URL in url as
    # parameter for urlopen
    for x in range(10):
        y = x + 1
        url = (
            "http://ecommerce.hackathon.seidor.digital/orders/?page="
            + str(y)
            + "&per_page=10"
        )

        # store the response of URL
        response = urlopen(url)

        # storing the JSON response
        # from url in data
        data_json = json.loads(response.read())

        # print the json response
        for order in range(10):
            order_items = data_json[order]["order_items"]
            for orderItem in order_items:
                print(Product(orderItem))
                print("----------------------")
            
def retrieve_users():
    # store the URL in url as
    # parameter for urlopen
    for x in range(10):
        y = x + 1
        url = (
            "http://ecommerce.hackathon.seidor.digital/orders/?page="
            + str(y)
            + "&per_page=10"
        )

        # store the response of URL
        response = urlopen(url)

        # storing the JSON response
        # from url in data
        data_json = json.loads(response.read())

        # print the json response
        for order in range(10):
            user = User(data_json[order])
            print(user)
            
def main_menu():
    print("--- Rebel Camp System ---")
    print("1.- Check All Products")
    print("2.- Check All Users")
    selection = input()

    if int(selection) == 1:
        retrieve_products();
        main_menu()
    elif int(selection) == 2:
        retrieve_users();
        main_menu()
    else:
        print("That's not an available option")
        main_menu()
 
main_menu()
