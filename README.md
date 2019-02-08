## stringTrieMap
Experimenting with a custom trie implementation using string chaining and HashMap

**Experiement**: Using a query string, find number of occurences of the query in an array of strings.

**Solution**:
1. Loop through array of strings, and append to a single long string; each added string value is followed by a marker ';'.
2. Loop through appended string, and append char at index of the string to another string that's initially empty.
    - Add second char appended string to a HashMap with the string as the key, and 1 as the value
    - If the string already exists update occurance value
3. Use query string as key for Map to get the value (occurences).

**Time Complexity**: O(n)
