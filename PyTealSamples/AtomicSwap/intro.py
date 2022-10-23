from pyteal import *

"""Atomic Swap"""

endpoint1 = Addr("X6PHUOKGSF3GFMYTLCGQML7A33IIOWLOQIAXTGSEIF73CGQO4TEX7VLWHQ")
endpoint2 = Addr("2OYMNMDMFGDJL3BXDCLMVWKNKFKD4YMDYJ6AIKHPYZNZNHRRGVX7BEAHT4")
secret = Bytes("base32", "23423423424")
timeout = 3000 

def atomic_swap(
    tmpl_seller = endpoint1, 
    tmpl_buyer = endpoint2,
    tmpl_fee = 1000,
    tmpl_secret = secret,
    tmpl_hash_fn = Sha256,
    tmpl_timeout = timeout,
):
