import React from 'react'

const FormField = ({ id, label, type, name, value, setValue, ...props}) => {
    const inputProps = { id, name, type, value, onChange: (event) => setValue(event.target.value) };
    return (

        <div className='col'>
            <label className='col-form-label' htmlFor={id}>{label}</label>
            <input 
                className='form-control' 
                id={id} 
                name={name}
                type={type}
                value={value}
                onChange={({target}) => setValue(target.value)}
                {...inputProps} 
                {...props}
                />
        </div>
    )
}

export default FormField;