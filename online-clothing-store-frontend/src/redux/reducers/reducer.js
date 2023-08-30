const INIT_STATE = {
    email:"",
    password:"",
    carts: [],
    wishlists: [],
    products:[]
};

export const cartreducer = (state = INIT_STATE, action) => {
    switch(action.type){

        case "ADD_CART":
            const ItemIndex = state.carts.findIndex((item)=>item.id === action.payload.id);
            if(ItemIndex >= 0){
                state.carts[ItemIndex].qnty +=1
            } 
            else{
                const temp ={...action.payload, qnty:1}
                return{
                ...state,
                carts:[...state.carts, temp]
                }
            }
        break;
        case "REMOVE_CART":
            const data = state.carts.filter((el)=>el.id !== action.payload);
            return{
            ...state,
            carts:data
            }
        
        case "WISHLIST_ITEM":
            const cData = state.carts.filter((el)=>el.id !== action.payload);
            const updatedWishlist = state.carts.filter((el)=>el.id === action.payload);
            return {
                ...state,
                    carts: cData,
                wishlists: [...state.wishlists, ...updatedWishlist]
            }


        case "MOVE_TO_CART":
            const wData = state.wishlists.filter((el)=>el.id !== action.payload);
            const cartData = state.wishlists.filter((el)=>el.id === action.payload);
            return {
                ...state,
                    carts:  [...state.carts, ...cartData],
                wishlists: wData
            }

        case "REMOVE_FROM_WISHLIST":
            const wishData = state.wishlists.filter((el)=>el.id !== action.payload);
            return {
                ...state,
                wishlists: wishData
            }

        default:
            return state
    }
}


//reducers/isLogged.js
export const loggedReducer = (state=false, action) => {
    switch(action.type){
        case "LOGIN":
            return !state;
        default:
            return state;
        }
    }


//reducers/isLogged.js
export const searchReducer = (state=INIT_STATE, action) => {
    switch(action.type){
        case "SEARCH_RESULT":
        const products=action.payload;
        return {
            ...state,
            products:products
        }
        default:
            return state;
        }
    }




    


