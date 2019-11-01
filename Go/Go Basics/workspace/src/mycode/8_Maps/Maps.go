package main

import "fmt"

func main() {
	// Maps are key value pairs

	nameAge := map[string]int{
		"James": 32,
		"Daisy": 27, //leave trailing comma! compiler will add semi-colon otherwise
	}

	fmt.Println(nameAge)
	fmt.Println(nameAge["James"])
	fmt.Println(nameAge["Barnabas"]) //If key doesn't exist, zero value is returned!

	//Comma ok idiom
	fmt.Println("comma ok style")

	v, ok := nameAge["Barnabas"]
	fmt.Println(v)
	fmt.Println(ok)

	if v, ok := nameAge["Daisy"]; ok {
		fmt.Println("Success, value is: ", v)
	}

	//Adding an entry to a map
	nameAge["todd"] = 34

	for k, v := range nameAge {
		fmt.Println(k, v)
	}

	//delete from map
	delete(nameAge, "James")
	delete(nameAge, "Does not exist - no error thrown")
	fmt.Println(nameAge)
}
